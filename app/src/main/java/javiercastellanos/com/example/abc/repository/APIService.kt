package javiercastellanos.com.example.abc.apis

import javiercastellanos.com.example.abc.model.AcademicaDTO
import javiercastellanos.com.example.abc.model.AnswerDTO
import javiercastellanos.com.example.abc.model.CandidatoInfoDTO
import javiercastellanos.com.example.abc.model.CandidatoInfoReponseDTO
import javiercastellanos.com.example.abc.model.CandidatoOutDTO
import javiercastellanos.com.example.abc.model.ContractsOutDTO
import javiercastellanos.com.example.abc.model.ContratoInDTO
import javiercastellanos.com.example.abc.model.EmpresasOutDTO
import javiercastellanos.com.example.abc.model.ExperienciaLaboralDTO
import javiercastellanos.com.example.abc.model.FinishTestDTO
import javiercastellanos.com.example.abc.model.InterviewOutDTO
import javiercastellanos.com.example.abc.model.LoginDTO
import javiercastellanos.com.example.abc.model.LoginResponseDTO
import javiercastellanos.com.example.abc.model.MetadataResponse
import javiercastellanos.com.example.abc.model.PerformanceEvaluationInDTO
import javiercastellanos.com.example.abc.model.PerformanceEvaluationOutDTO
import javiercastellanos.com.example.abc.model.ProjectOutDTO
import javiercastellanos.com.example.abc.model.QuestionOutDTO
import javiercastellanos.com.example.abc.model.RegistroDTO
import javiercastellanos.com.example.abc.model.RegistroOutDTO
import javiercastellanos.com.example.abc.model.StartTestOutDTO
import javiercastellanos.com.example.abc.model.TestResponseDTO
import javiercastellanos.com.example.abc.model.UsersOutDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {

    /**
     * Obtiene productos del servicio por medio de una query
     * @param query
     **/
    @POST("/registro/usuario")
    suspend fun registro(
        @Body registroDTO: RegistroDTO
    ): Response<RegistroOutDTO>


    @POST("/registro/login")
    suspend fun login(
        @Body loginDTO: LoginDTO
    ): Response<LoginResponseDTO>

    /**
     * Obtiene descripción del producto
     * @param item_id
     **/
    @GET("candidato/metadata")
    suspend fun getMetadata(

    ): Response<MetadataResponse>

    @POST("/candidato/")
    suspend fun saveCandidato(
        @Body candidatoInfoDTO: CandidatoInfoDTO
    ): Response<CandidatoOutDTO>

    @POST("candidato/infoAcademica")
    suspend fun saveCandidatoAcademica(
        @Body academicaDTO: AcademicaDTO
    ): Response<String>

    @POST("candidato/experiencia")
    suspend fun saveCandidatoExperiencia(
        @Body experienciaLaboralDTO: ExperienciaLaboralDTO
    ): Response<String>

    @GET("candidato/info/{email}")
    suspend fun getCandidato(
        @Path("email") email: String
    ): Response<CandidatoInfoReponseDTO>

    @GET("evaluacion/obtener/{idCandidato}")
    suspend fun getTests(
        @Path("idCandidato") idCandidato: Int
    ): Response<TestResponseDTO>

    @POST("evaluacion/iniciar/{idTest}")
    suspend fun startTest(
        @Path("idTest") idTest: Int
    ): Response<StartTestOutDTO>

    @GET("evaluacion/pregunta/solicitar/{idTest}")
    suspend fun getQuestion(
        @Path("idTest") idTest: Int
    ): Response<QuestionOutDTO>

    @POST("evaluacion/pregunta/responder")
    suspend fun answerQuestion(
        @Body answerDTO: AnswerDTO
    ): Response<String>

    @POST("evaluacion/finalizar/{idTest}")
    suspend fun finishTest(
        @Path("idTest") idTest: Int
    ): Response<FinishTestDTO>

    @GET("empresa")
    suspend fun getCompanies(): Response<EmpresasOutDTO>

    @GET("candidato")
    suspend fun getCandidatos(): Response<UsersOutDto>

    @GET("empresa/proyecto/{id}")
    suspend fun getProjects(
        @Path("id") id: Int
    ): Response<ProjectOutDTO>

    @POST("empresa/contrato")
    suspend fun saveContrato(
        @Body contrato: ContratoInDTO
    ): Response<String>

    @GET("empresa/contrato/{tipoUser}/{id}")
    suspend fun getContracts(
        @Path("tipoUser") tipoUser: Int,
        @Path("id") id: Int
    ) : Response<ContractsOutDTO>

    @POST ("evaluacion/desempeno")
    suspend fun savePerformanceEvaluation(
        @Body performanceEvaluationInDTO: PerformanceEvaluationInDTO
    )  : Response<PerformanceEvaluationOutDTO>

    @GET("candidato/entrevista/{id}")
    suspend fun getInterview(
        @Path("id") id: Int
    ) : Response<InterviewOutDTO>
}