using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Infrastructure;

namespace demoServer.Controllers
{
    [Route("api/images")]
    public class ImagesController : ControllerBase
    {
        public IWebHostEnvironment _env { get; set; }
        public ImagesController(IWebHostEnvironment env)
        {
            _env = env;
        }


        [HttpGet("{name}")]
        public IActionResult getImage(string name)
        {
            byte[] imageBytes = System.IO.File.ReadAllBytes($"{_env.WebRootPath}/{name}.jpg");
            string contentType = "image/jpeg";
            return File(imageBytes, contentType);
        }
    }
}
