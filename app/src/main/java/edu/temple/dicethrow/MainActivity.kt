package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if(R.id.fragmentContainerView != null) {
//            if (savedInstanceState == null) {
//                supportFragmentManager
//                    .beginTransaction()
//                    .add(R.id.fragmentContainerView, DieFragment())
//                    .commit()
//            }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            (supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView) as DieFragment).throwDie()
        }
        //need to implement savedInstanceState when a fragment is destroyed/recreated
    }
}