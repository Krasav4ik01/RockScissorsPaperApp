package com.example.rockscissorspaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class Game : AppCompatActivity() {
    private lateinit var scissorBtn: Button
    private lateinit var rockBtn: Button
    private lateinit var paperBtn: Button
    private lateinit var opponentsImage: ImageView
    private lateinit var yourImage: ImageView
    private lateinit var opponentsScoreText: TextView
    private lateinit var yourScoreText: TextView
    private lateinit var counterText: TextView

    var opponentsScore: Int = 0
    var yourScore: Int = 0
    var counter: Int = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        scissorBtn = findViewById(R.id.scissor_btn)
        rockBtn = findViewById(R.id.rock_btn)
        paperBtn = findViewById(R.id.paper_btn)
        opponentsImage = findViewById(R.id.opponents_image)
        yourImage = findViewById(R.id.your_image)
        opponentsScoreText = findViewById(R.id.opponents_score)
        yourScoreText = findViewById(R.id.your_score)



        scissorBtn.setOnClickListener {
            check("scissors")
            yourImage.setImageResource(R.drawable.scissors)
        }
        rockBtn.setOnClickListener {
            check("rock")
            yourImage.setImageResource(R.drawable.rock)
        }
        paperBtn.setOnClickListener {
            check("paper")
            yourImage.setImageResource(R.drawable.paper)
        }
    }

    private fun check(myChoice: String){

        var opponentsChoice = ""
        var randomNum = Random.nextInt(3)

        if (randomNum == 0){
            opponentsChoice = "rock"
            opponentsImage.setImageResource(R.drawable.rock)
        }
        if (randomNum == 1){
            opponentsChoice = "scissors"
            opponentsImage.setImageResource(R.drawable.scissors)
        }
        if (randomNum == 2){
            opponentsChoice = "paper"
            opponentsImage.setImageResource(R.drawable.paper)
        }

        if (opponentsChoice == myChoice ){
            Toast.makeText(this, "Tie", Toast.LENGTH_SHORT).show()
        }
        if (opponentsChoice == "rock" && myChoice == "scissors"){
            opponentsScore  = opponentsScore + 1
            opponentsScoreText.setText("$opponentsScore")
            yourScoreText.setText("$yourScore")
        }
        if (opponentsChoice == "rock" && myChoice == "paper"){
            yourScore  = yourScore + 1
            opponentsScoreText.setText("$opponentsScore")
            yourScoreText.setText("$yourScore")
        }
        if (opponentsChoice == "paper" && myChoice == "scissors"){
            yourScore  = yourScore+ 1
            opponentsScoreText.setText("$opponentsScore")
            yourScoreText.setText("$yourScore")
        }
        if (opponentsChoice == "paper" && myChoice == "rock"){
            opponentsScore  = opponentsScore+ 1
            opponentsScoreText.setText("$opponentsScore")
            yourScoreText.setText("$yourScore")
        }
        if (opponentsChoice == "scissors" && myChoice == "rock"){
            yourScore  = yourScore+ 1
            opponentsScoreText.setText("$opponentsScore")
            yourScoreText.setText("$yourScore")
        }
        if (opponentsChoice == "scissors" && myChoice == "paper"){
            opponentsScore  = opponentsScore+ 1
            opponentsScoreText.setText("$opponentsScore")
            yourScoreText.setText("$yourScore")
        }


    }
}