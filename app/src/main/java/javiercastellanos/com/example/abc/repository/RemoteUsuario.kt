package javiercastellanos.com.example.abc.repository

import javiercastellanos.com.example.abc.apis.RetrofitHelper
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
import javiercastellanos.com.example.abc.model.StartTestOutDTO
import javiercastellanos.com.example.abc.model.TestResponseDTO
import javiercastellanos.com.example.abc.model.UsersOutDto
import retrofit2.Response

class RemoteUsuario {
    suspend fun registro(registroDTO: RegistroDTO): Response<String> {
        return RetrofitHelper.service.registro(registroDTO)
    }
    suspend fun login(loginDTO: LoginDTO): Response<LoginResponseDTO> {
        return RetrofitHelper.service.login(loginDTO)
    }

    suspend fun getMetadata(): Response<MetadataResponse> {
        return RetrofitHelper.service.getMetadata()
    }

    suspend fun saveCandidato(candidatoInfoDTO: CandidatoInfoDTO): Response<CandidatoOutDTO> {
        return RetrofitHelper.service.saveCandidato(candidatoInfoDTO)
    }

    suspend fun saveExperienciaLaboral(experienciaLaboralDTO: ExperienciaLaboralDTO): Response<String> {
        return RetrofitHelper.service.saveCandidatoExperiencia(experienciaLaboralDTO)
    }

    suspend fun saveInformacionAcademica(informacionAcademicaDTO: AcademicaDTO): Response<String> {
        return RetrofitHelper.service.saveCandidatoAcademica(informacionAcademicaDTO)
    }

    suspend fun getCandidato(email: String): Response<CandidatoInfoReponseDTO> {
        return RetrofitHelper.service.getCandidato(email = email)
    }

    suspend fun getTests(idCandidato: Int): Response<TestResponseDTO> {
        return RetrofitHelper.service.getTests(idCandidato = idCandidato)
    }

    suspend fun startTest( idTest: Int): Response<StartTestOutDTO> {
        return RetrofitHelper.service.startTest(idTest = idTest)
    }

    suspend fun getQuestion(idTest: Int): Response<QuestionOutDTO> {
        return RetrofitHelper.service.getQuestion(idTest = idTest)
    }

    suspend fun answerQuestion(answerDTO: AnswerDTO): Response<String> {
        return RetrofitHelper.service.answerQuestion(answerDTO)
    }

    suspend fun finishTest(idTest: Int): Response<FinishTestDTO> {
        return RetrofitHelper.service.finishTest(idTest = idTest)
    }

    suspend fun getCompanies(): Response<EmpresasOutDTO> {
        return RetrofitHelper.service.getCompanies()
    }

    suspend fun getCandidatos(): Response<UsersOutDto> {
        return RetrofitHelper.service.getCandidatos()
    }

    suspend fun getProjects(id: Int): Response<ProjectOutDTO> {
        return RetrofitHelper.service.getProjects(id = id)
    }
    suspend fun saveContrato(contrato: ContratoInDTO): Response<String> {
        return RetrofitHelper.service.saveContrato(contrato)
    }
    suspend fun getContracts(id: Int, idTipoUser: Int): Response<ContractsOutDTO> {
        return RetrofitHelper.service.getContracts(id = id, tipoUser = idTipoUser)
    }

    suspend fun savePerformanceEvaluation(performanceEvaluationInDTO: PerformanceEvaluationInDTO): Response<PerformanceEvaluationOutDTO> {
        return RetrofitHelper.service.savePerformanceEvaluation(performanceEvaluationInDTO)
    }

    suspend fun getInterview(id: Int): Response<InterviewOutDTO> {
        return RetrofitHelper.service.getInterview(id = id)
    }
}