package javiercastellanos.com.example.abc.apis
import javiercastellanos.com.example.abc.model.LoginDTO
import javiercastellanos.com.example.abc.model.LoginResponseDTO
import javiercastellanos.com.example.abc.model.RegistroDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    /**
     * Obtiene productos del servicio por medio de una query
     * @param query
     **/
    @POST("/registro/usuario")
    suspend fun registro(
        @Body registroDTO: RegistroDTO
    ): Response<String>


    @POST("/registro/login")
    suspend fun login(
        @Body loginDTO: LoginDTO
    ): Response<LoginResponseDTO>
    /**
     * Obtiene descripción del producto
     * @param item_id
     **/
    /*@GET("/items/{ITEM_ID}/description")
    suspend fun getDescriptionByProductId(
        @Path("ITEM_ID") item_id: String?
    ): Response<Description>

    /**
     * Obtiene informacion del producto
     * @param item_id
     **/
    @GET("/items/{ITEM_ID}")
    suspend fun getItemByProductId(
        @Path("ITEM_ID") item_id: String?
    ): Response<Item>*/
}