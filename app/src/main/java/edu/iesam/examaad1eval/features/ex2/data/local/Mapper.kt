package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.Player

fun GameEntity.toModel(): Game{
    return Game(
        this.id,
        this.title,
        this.player
    )
}

fun Game.toEntity(): GameEntity {
    return GameEntity(
        this.id,
        this.title,
        this.player
    )
}

fun PlayerEntity.toModel(): Player {
    return Player(
        this.id,
        this.name
    )
}

fun Player.toEntity(): PlayerEntity {
    return PlayerEntity(
        this.id,
        this.name)
}