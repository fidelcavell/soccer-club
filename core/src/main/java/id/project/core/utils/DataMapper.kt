package id.project.core.utils

import id.project.core.data.source.local.entity.SoccerClubEntity
import id.project.core.data.source.remote.response.SoccerClubResponse
import id.project.core.domain.model.SoccerClub

object DataMapper {
    fun mapResponsesToEntities(input: List<SoccerClubResponse>): List<SoccerClubEntity> {
        val soccerClubList = ArrayList<SoccerClubEntity>()
        input.map {
            val soccerClub = SoccerClubEntity(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strLocation = it.strLocation,
                strCountry = it.strCountry,
                strDescriptionEN = it.strDescriptionEN,
                strFanArt = it.strFanArt
            )
            soccerClubList.add(soccerClub)
        }

        return soccerClubList
    }

    fun mapEntitiesToDomain(input: List<SoccerClubEntity>): List<SoccerClub> {
        return input.map {
            SoccerClub(
                id = it.id,
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strLocation = it.strLocation,
                strCountry = it.strCountry,
                strDescriptionEN = it.strDescriptionEN,
                strFanArt = it.strFanArt,
                isFavorite = it.isFavorite
            )
        }
    }

    fun mapDomainToEntity(input: SoccerClub) =
        SoccerClubEntity(
            id = input.id,
            idTeam = input.idTeam,
            strTeam = input.strTeam,
            strLocation = input.strLocation,
            strCountry = input.strCountry,
            strDescriptionEN = input.strDescriptionEN,
            strFanArt = input.strFanArt,
            isFavorite = input.isFavorite
        )
}