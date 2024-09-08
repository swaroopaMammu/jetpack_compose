package com.example.mycomposeapp.model

import com.example.mycomposeapp.R
import com.google.gson.Gson

object ApplicationData {

    val animationMovieList = arrayListOf(
        MoviesModel(
            movieId = 100,
            movieName = "Spirited Away",
            poster = R.drawable.spiritedaway,
            description = "Miyazaki wrote the screenplay after he decided the film would be based on the ten-year-old daughter of his friend Seiji Okuda, the film's associate producer, who came to visit his house each summer"
        ),
        MoviesModel(
            movieId = 101,
            movieName = "Luca",
            poster = R.drawable.luca,
            description = "Luca draws inspiration from Casarosa's childhood in Genoa, Italy. Several Pixar artists were sent to the Italian Riviera gathering research from Italian culture and environment to create Portorosso, the primary setting."
        ),
        MoviesModel(
            movieId = 102,
            movieName = "Coco",
            poster = R.drawable.coco,
            description = "The concept for Coco is inspired by the Mexican holiday Day of the Dead. Pixar began developing the animation in 2016. Unkrich, Molina, Anderson, and some of the film's crew visited Mexico for research. "
        ),
        MoviesModel(
            movieId = 103,
            movieName = "Corpse Bride",
            poster = R.drawable.corsebride,
            description = "Corpse Bride is based on a 17th-century Jewish folktale, which Joe Ranft introduced to Burton while they were finishing The Nightmare Before Christmas. Work on the film started in November 2003 when Burton was completing Big Fish (2003)."
        ),
        MoviesModel(
            movieId = 104,
            movieName = "Inside Out2",
            poster = R.drawable.insideout,
            description = "Work on Inside Out 2 commenced in 2020 after Mann saw photos of his birthday during upbringing. The film features Pixar chief creative officer Pete Docter's five to 27 emotions idea from the first film that Mann pitched during its production to utilize truthful worldbuilding."
        ),
        MoviesModel(
            movieId = 105,
            movieName = "Brave",
            poster = R.drawable.brave,
            description = "Brave is Pixar's first film with a female protagonist, and the first one animated with a new proprietary animation system, called Presto.[3] Originally titled The Bear and the Bow, the film was first announced in April 2008 alongside Up (2009) and Cars 2 (2011). Chapman, who had just wrapped up work as a story artist on Cars (2006), drew inspiration for the film's story from her relationship with her own daughter."
        ),
        MoviesModel(
            movieId = 106,
            movieName = "Big Hero 6",
            poster = R.drawable.bighero6,
            description = "Big Hero 6 is the first Disney animated film to feature Marvel Comics characters, whose parent company was acquired by the Walt Disney Company in 2009. Walt Disney Animation Studios created new software technology to produce the animated visuals"
        ),
        MoviesModel(
            movieId = 107,
            movieName = "Hotel Transylvania",
            poster = R.drawable.hoteltransylvania,
            description = "The film tells the story of Count Dracula, the owner of the titular Hotel Transylvania where the world's monsters can take a rest from human civilization. Dracula invites some of the most famous monsters to celebrate the 118th birthday of his beloved daughter Mavis"
            ),
        MoviesModel(
            movieId = 108,
            movieName = "How To Train Your Dragon",
            poster = R.drawable.howtotrainyourdragon,
            description = "The television series based on the events of the first film, DreamWorks Dragons, began airing on Cartoon Network in September 2012. The first and second seasons were titled Dragon: Riders of Berk and Dragons: Defenders of Berk respectively. "
        )
    )

    val favouriteMovieList = arrayListOf(
        MoviesModel(
            movieId = 200,
            movieName = "Interstellar",
            poster = R.drawable.interstellar,
            description = "The screenplay had its origins in a script Jonathan developed in 2007 and was originally set to be directed by Steven Spielberg. Theoretical physicist Kip Thorne was an executive producer and scientific consultant on the film, and wrote the tie-in book The Science of Interstellar."
        ),
        MoviesModel(
            movieId = 201,
            movieName = "Gifted",
            poster = R.drawable.gifted,
            description = "On her first day of first grade, Mary shows remarkable mathematical talent, which impresses her teacher, Bonnie Stevenson. She approaches Frank about it but he tries to pass it off as the Trachtenberg system until she tricks Mary into completing a college math test, and confronts him again."
        ),
        MoviesModel(
            movieId = 202,
            movieName = "La La Land",
            poster = R.drawable.lalaland,
            description = "Having been fond of musicals during his time as a drummer, Chazelle first conceptualized the film alongside Justin Hurwitz while attending Harvard University together. "
        ),
        MoviesModel(
            movieId = 203,
            movieName = "Me Before You",
            poster = R.drawable.mebeforeyou,
            description = "Louisa Lou Clark is hired as carer for Will Traynor, a once successful banker and active sportsman now tetraplegic after being hit by a motorcycle. Will's mother hopes Lou's bubbly personality will lift Will's depressed and cynical spirits. Will is initially cold towards Lou. "
        ),
        MoviesModel(
            movieId = 204,
            movieName = "Five Feet Apart",
            poster = R.drawable.fivefeetapart,
            description = "Teenagers Stella Grant and Will Newman have cystic fibrosis (CF), a progressive genetic disorder that damages organs and makes patients vulnerable to infections. Because of their compromised immune systems, patients with CF should get no closer than six feet to each other."
        ),
        MoviesModel(
            movieId = 205,
            movieName = "Miracle Cell No.7",
            poster = R.drawable.miracleincellno7,
            description = "Ye-sung is a lawyer defending her late father for a crime he did not commit. While leaving the prison court after a successful trial, Ye-sung notices a balloon caught on barbed wire and reminisces."
        ),
        MoviesModel(
           movieId = 206,
            movieName = "Persuit Of Happiness",
            poster = R.drawable.persuitofhappiness,
            description = "The film was released on December 15, 2006, by Columbia Pictures, and received positive reviews, with Smith's performance and the emotional weight of the story garnering acclaim. Smith was nominated for an Oscar and a Golden Globe for Best Actor"
        )
    )

    fun List<MoviesModel>.toJson(): String = Gson().toJson(this)
    fun String.toMovieModelList(): List<MoviesModel> =
        Gson().fromJson(this, Array<MoviesModel>::class.java).toList()

}