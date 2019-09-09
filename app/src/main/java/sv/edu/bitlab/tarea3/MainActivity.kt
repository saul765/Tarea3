package sv.edu.bitlab.tarea3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import sv.edu.bitlab.tarea3.entity.FrameThread

class MainActivity : AppCompatActivity() {

    var phoneNumber:String=""
    val mainHandler = Handler()
    @Volatile var stopThread:Boolean?=null
    lateinit var run: FrameThread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        headText.setText("")


        one.setOnClickListener{
            phoneNumber+=1
            headText.setText(phoneNumber)

        }
        two.setOnClickListener{
            phoneNumber+=2
            headText.setText(phoneNumber)
        }
        three.setOnClickListener{
            phoneNumber+=3
            headText.setText(phoneNumber)
        }
        four.setOnClickListener{
            phoneNumber+=4
            headText.setText(phoneNumber)
        }
        five.setOnClickListener{
            phoneNumber+=5
            headText.setText(phoneNumber)
        }
        six.setOnClickListener{
            phoneNumber+=6
            headText.setText(phoneNumber)
        }
        seven.setOnClickListener{
            phoneNumber+=7
            headText.setText(phoneNumber)
        }
        eight.setOnClickListener{
            phoneNumber+=8
            headText.setText(phoneNumber)
        }
        nine.setOnClickListener{
            phoneNumber+=9
            headText.setText(phoneNumber)
        }
        zero.setOnClickListener{
            phoneNumber+=0
            headText.setText(phoneNumber)
        }
        cButton.setOnClickListener {
            phoneNumber+="*"
            headText.setText(phoneNumber)
        }
        erase.setOnClickListener{

            phoneNumber=phoneNumber.dropLast(1)
            Log.d("mainactivity",phoneNumber)
            headText.setText(phoneNumber)


        }

        callButton.setOnClickListener {
            callingNumberTxtview.text=phoneNumber
            callingNumberTxtview.visibility= View.VISIBLE
            callingTxtview.visibility= View.VISIBLE
            blackFrame.visibility= View.VISIBLE
            stopThread=false
            run = FrameThread(mainHandler, this, stopThread!!)
            Thread(run).start()

        }
        blackFrame.setOnClickListener {
            callingTxtview.visibility= View.GONE
            blackFrame.visibility= View.GONE
            stopThread=true
            run.stopThread=stopThread!!

        }

    }
}
