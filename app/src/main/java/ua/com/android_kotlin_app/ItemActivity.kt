package ua.com.android_kotlin_app

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject

class ItemActivity : AppCompatActivity(), PaymentResultWithDataListener, ExternalWalletListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)


        Checkout.preload(applicationContext)
        val co = Checkout()

        co.setKeyID("rzp_test_avWIfx2lYjgj9B")

        val btn :Button = findViewById(R.id.button_buy)
        val image : ImageView = findViewById(R.id.item_list_image)
        val title :TextView = findViewById(R.id.item_list_title_one)
        val text :TextView = findViewById(R.id.item_list_text)
        val price :TextView = findViewById(R.id.item_list_price)


        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        price.text = intent.getStringExtra("itemPrice")
        val imageResourceName = intent.getStringExtra("itemImage")
        val imageResourceId = resources.getIdentifier(imageResourceName, "drawable", packageName)
        image.setImageResource(imageResourceId)

        btn.setOnClickListener{


            startPayment()
        }
    }

    private fun startPayment() {
        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","SD")
            options.put("description","Demoing Charges")
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#3399cc")
            options.put("currency","USD")
            options.put("order_id", "order_MpdEzhbRTiqoT3")
            options.put("amount",10000)
            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        Toast.makeText(this, "Payment successful", Toast.LENGTH_LONG)
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Toast.makeText(this, "Payment erroe", Toast.LENGTH_LONG)
    }

    override fun onExternalWalletSelected(p0: String?, p1: PaymentData?) {

    }
}