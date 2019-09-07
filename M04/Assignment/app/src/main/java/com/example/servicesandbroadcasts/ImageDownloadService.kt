package com.example.servicesandbroadcasts

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.lang.UnsupportedOperationException

class ImageDownloadService: Service() {
    companion object{
        const val BITMAP_WIDTH = "width"
        const val BITMAP_HEIGHT = "height"
        const val FILE_DOWNLOADED_ACTION = "com.example.servicesandbroadcasts.FILE_DOWNLOADED"
        const val DOWNLOADED_IMAGE = "downloadedimage"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("ImageDownloader", "started")

        Thread(Runnable {
            val bitmap = NetworkAdapter.getBitmapFromUrl("https://t2.ftcdn.net/jpg/01/76/34/53/400_F_176345331_Xc5a80s4eSpDT414hexzb7trwepcPrsn.jpg")



            val intent = Intent(FILE_DOWNLOADED_ACTION).apply {
                putExtra(DOWNLOADED_IMAGE, bitmap)

            }

            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            stopSelf()

        }).start()

        return super.onStartCommand(intent, flags, startId)


    }

    override fun onCreate() {
        super.onCreate()
        Log.i("ImageDownloader", "created")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ImageDownloader", "destroyed")
    }
    //Step 4 of readme Setup the Service class



    override fun onBind(p0: Intent?): IBinder? {
        throw UnsupportedOperationException()
    }
}