using Microsoft.AspNetCore.Mvc;

namespace demoServer.Controllers
{
    [ApiController]
    [Route("api/")]
    public class CategoryController : ControllerBase
    {
        [HttpGet("getAll")]
        public IActionResult GetCategories()
        {
            return Ok(DataStore.Categories);
        }
    }
}