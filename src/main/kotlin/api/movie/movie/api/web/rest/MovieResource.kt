package api.movie.movie.api.web.rest

import api.movie.movie.api.dto.MovieDTO
import api.movie.movie.api.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MovieResource (
    private val movieService: MovieService) {

    @PostMapping("/movies")
    fun createMovie(@RequestBody movieDTO: MovieDTO): ResponseEntity<MovieDTO> {
        return ResponseEntity(movieService.createMovie(movieDTO), HttpStatus.CREATED)
    }

    @GetMapping("/movies")
    fun getMovies(): ResponseEntity<List<MovieDTO>> {
        return ResponseEntity(movieService.getMovies(), HttpStatus.OK)
    }

    @GetMapping("/movies/{id}")
    fun getMovie(@PathVariable id: Int): ResponseEntity<MovieDTO> {
        return ResponseEntity(movieService.getMovie(id), HttpStatus.OK)
    }

    @PutMapping("/movies")
    fun updateMovie(@RequestBody movieDTO: MovieDTO): ResponseEntity<MovieDTO> =
        ResponseEntity.ok(movieService.updateMovie(movieDTO))

    @DeleteMapping("/movies/{id}")
    fun deleteMovie(@PathVariable id: Int): ResponseEntity<Unit> =
        ResponseEntity(movieService.deleteMovie(id), HttpStatus.NO_CONTENT)

}