public class School<T>
{
    T name;
    T area;
    public School(T name, T area)
    {
        this.name = name;
        this.area = area;
    }
    public T getName()
    {
        return name;
    }
    public void setName(T name)
    {
         this.name = name;
    }

    public T getArea()
    {
        return area;
    }

    public void setArea(T area)
    {
        this.area = area;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "name=" + name + ", area=" + area;
    }

    public T getBothNameAndArea(T name, T area)
    {
        T bothNameAndArea = name.equals(area) ? this.name : this.area;
        return bothNameAndArea;
    }

}
