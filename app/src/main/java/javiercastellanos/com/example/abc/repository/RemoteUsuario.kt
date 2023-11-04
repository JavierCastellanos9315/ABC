package javiercastellanos.com.example.abc.repository

import com.google.gson.JsonObject
import javiercastellanos.com.example.abc.apis.RetrofitHelper
import javiercastellanos.com.example.abc.model.AcademicaDTO
import javiercastellanos.com.example.abc.model.CandidatoInfoDTO
import javiercastellanos.com.example.abc.model.CandidatoInfoReponseDTO
import javiercastellanos.com.example.abc.model.CandidatoOutDTO
import javiercastellanos.com.example.abc.model.ExperienciaLaboralDTO
import javiercastellanos.com.example.abc.model.InformacionAcademica
import javiercastellanos.com.example.abc.model.LoginDTO
import javiercastellanos.com.example.abc.model.LoginResponseDTO
import javiercastellanos.com.example.abc.model.MetadataResponse
import javiercastellanos.com.example.abc.model.RegistroDTO
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
}