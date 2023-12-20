public class Product
{
    public int Id { get; set; }
    public string? Name { get; set; }
    public double Price { get; set; }
    public string? Image { get; set; }
}

class Category
{
    public string? Name { get; set; }
    public List<Product>? Products { get; set; }
}