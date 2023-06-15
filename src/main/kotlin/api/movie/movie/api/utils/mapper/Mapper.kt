package api.movie.movie.api.utils.mapper

interface Mapper<D, E> {


    fun fromEntity(entity: E): D
    fun toEntity(domain: D): E
}