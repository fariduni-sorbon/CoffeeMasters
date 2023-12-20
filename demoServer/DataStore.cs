class DataStore
{
    public static List<Category> Categories = new List<Category>{
       new Category
            {
                Name = "HOT COFFEE",
                Products = new List<Product>
                {
                    new Product { Id = 1, Name = "Product 1", Price = 19.99, Image = "111" },
                    new Product { Id = 2, Name = "Product 2", Price = 29.99, Image = "222" }
                }
            },
            new Category
            {
                Name = "ICED COFFEE",
                Products = new List<Product>
                {
                    new Product { Id = 3, Name = "Product 3", Price = 39.99, Image = "333" },
                    new Product { Id = 4, Name = "Product 4", Price = 49.99, Image = "444" }
                }
            }
   };
}