
import com.jetpackexample.coffeemasters.Category
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CoffeeMastersApiService {
    @GET("getAll")
    suspend fun fetchMenu(): List<Category>

    object API {
        private val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("http://20.20.20.10:5257/api/").addConverterFactory(GsonConverterFactory.create())
                .build()

        val menuService: CoffeeMastersApiService by lazy { retrofit.create(CoffeeMastersApiService::class.java) }

    }
}