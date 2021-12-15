package ru.kirillag.hunterio

import com.badlogic.gdx.Game
import ru.kirillag.hunterio.screens.GameScreen

class HunterIO : Game() {

    override fun create() {
        setScreen(GameScreen());
    }
}
