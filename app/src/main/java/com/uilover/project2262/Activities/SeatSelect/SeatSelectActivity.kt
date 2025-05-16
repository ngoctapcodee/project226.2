package com.uilover.project2262.Activities.SeatSelect

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.uilover.project2262.Activities.Splash.StatusTopBarColor
import com.uilover.project2262.Activities.TicketDetail.TicketDetailActivity
import com.uilover.project2262.Domain.FlightModel

class SeatSelectActivity : AppCompatActivity() {
    private lateinit var flight: FlightModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        flight = intent.getSerializableExtra("flight") as FlightModel

        setContent {
            StatusTopBarColor()

            SeatListScreen(
                flight = flight,
                onBackClick = {
                    finish()
                }, onConfirm = {
                    val intent = Intent(this, TicketDetailActivity::class.java).apply {
                        putExtra("flight", flight)
                    }
                    startActivity(intent, null)
                }
            )
        }
    }
}