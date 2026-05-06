1.add the spring-batch-starter dependency 
2.keep the sql file in schema.sql for DDL and data.sql for inserting data 
3.Then config the BatchConfig define Jobs and steps init .
- **Transaction manager**: manages database transaction lifecycle.
- **`PlatformTransactionManager`**: Spring’s common interface for transaction managers.
- **`JpaTransactionManager`**: actual transaction manager used for JPA/Hibernate.Its class .Its implements PlatformTransactionManager
- In Spring Batch, `.chunk(10, transactionManager)` means each chunk of 10 items read,processed,and write  inside a transaction.
- If its sucessful then commits the data.otherwise rollback the data as if nothing transaction is happend .Thats ow transaction works 

Spring Batch needs to know: `JobRepository`
- Which jobs have already run
- Whether a job completed successfully
- Whether a job failed
- Whether a failed job can be restarted
- What steps were executed
- How many records were read, processed, and written

Without , Spring Batch cannot properly manage batch job lifecycle. `JobRepository`

Basically Job repository is needed to store spring batch job metadata in db created metadata tables like BATCH_* table

To create the object of job JobBuilder is used .Since Job is interface cannot create object directly 
Job job=new SimpleJob();

SimpleJOb is Implementation lass . Create an object of implementation class and store it in JOb type .
JobBuilder does this .And hides the logic .we can just use this builder pattern to create the object and launch the job .
create an object of the `Job` interface directly. `JobBuilder`
It creates a concrete implementation class, such as SimpleJob, and returns it using the `Job` interface type. `SimpleJob`


Here I used JpaPagingItemReader and JpaItemWriter which internally implenments item reader and Itemwriter .
So no need to define it as a class . Its alraedy defined .Just need to create bean for this and use it for the logic 

## 1**. What is Partitioning?**
**Partitioning means splitting the total data into smaller independent parts**, so they can be processed separately.
suppose i have 50000 data in the raw table . and rid size is 10 
50,000/10=5000 each grid has 5000 data .ANd that can work independently by different thread.

Pagination
Next is Pagination . Suppose my partition has 5000 data . Even after partition .not picking all the data at 
once . 
Each person does not pick all `5,000` papers at once.
They pick `1,000` papers from their pile at a time.
That is paging.

| Page size | How many records reader fetches from DB at once |
| --- | --- |

| Chunk size | How many records are processed/written per transaction | 500 records per commit |
| --- | --- | --- |


### Chunking
Even after picking `1,000` papers, they submit work in batches of `500`.
Page 1: 1000 records fetched
Chunk 1: records 1 - 500 processed and written
Chunk 2: records 501 - 1000 processed and written
Page 2: next 1000 records fetched
Fetch 1000 records into memory
↓
Process/write first 500
↓
Commit chunk 1
↓
Process/write next 500
↓
Commit chunk 2
↓
Reader moves to next page
↓
Previous 1000 records can become eligible for garbage collection
After chunk commit, Spring Batch no longer needs that chunk data.
But because page size is 1000, the reader may keep the full 1000-record page until the page is finished.
Once no references remain, the JVM garbage collector can clean the memory later

| DB page fetch | Bulk, 1000 records at a time |
| --- | --- |
| `ItemReader.read()` | One item at a time |
| `ItemProcessor.process()` | One item at a time |
| `ItemWriter.write()` | Bulk, 500 items at a time |
| Transaction commit | Once per chunk |


Java Long        <-> SQL BIGINT
Java Integer     <-> SQL INT / INTEGER
Java BigDecimal  <-> SQL DECIMAL / NUMERIC
Java BigInteger  <-> SQL very large NUMERIC

TIMESTAMP WITH TIME ZONE-OffsetDateTime
TIMESTAMP WITHOUT TIMEZONE-LocalDateTime
SQL DATE-LocalDAte
SQL Time-LocalTime
these are from java.time packages.


Spring Batch doesnot use the repository layer like normal rest API crud opertaion 
@Query(""Select c from customer c")
BEcause if all the data is read once it wll lead to memoery issue 

So Sprinbatch support entityMAnager to create query and updatequery and so on JPA processes
entityManager.createQuery(")



Used partiooner to implent in Partitonclass which gives method partiotion of return type map with Stirng and ExecutionContext

ExecutionContext is special Spring batch class there we can store data in the form of key value like map ,its not Map directly its special class 

It has so many methods to put data in it 

Then passing this execution context value min id and max id to reader with 

@Value("#{stepExecutionContext['minId']}") Long minId,
@Value("#{stepExecutionContext['maxId']}") Long maxId,
@Value("${app.batch.page-size}") int pageSize)

@StepScope 
this is very important when you inject value during step execution and it changes for every steps 
If we dont use @StepScope . When the application starts spring tries to inject this beans ,But it did not find any min id and max id and throw the error 

Here @Value should be spering application value not lombok value .



