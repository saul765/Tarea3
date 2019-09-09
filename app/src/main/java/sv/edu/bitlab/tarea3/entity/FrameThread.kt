package sv.edu.bitlab.tarea3.entity

import android.app.Activity
import android.os.Handler
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class FrameThread:Runnable {

    var handler:Handler
    var activity:Activity
    var stopThread:Boolean

    constructor(handler:Handler,activity: Activity,stopThread: Boolean){

        this.handler=handler
        this.activity=activity
        this.stopThread=stopThread

    }


    override fun run() {

        for (x in 1..10){


            if (this.stopThread){
                return
            }
        var run = Runnable {
                Log.d("main","for numeber $x")
            if (x==10) {
                this.activity.blackFrame.visibility = View.GONE
            }

        }
            this.handler.post{

                run.run()
            }
            try {
                Thread.sleep(1000)
            }catch (ex: Exception){
                ex.printStackTrace()

            }
        }
    }
}