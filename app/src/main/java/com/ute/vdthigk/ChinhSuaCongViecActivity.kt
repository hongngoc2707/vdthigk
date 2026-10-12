package com.ute.vdthigk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        val edtSuaTen = findViewById<EditText>(R.id.edtSuaTen)
        val edtSuaMoTa = findViewById<EditText>(R.id.edtSuaMoTa)
        val btnLuu = findViewById<Button>(R.id.btnLuu)

        // Hiển thị dữ liệu cũ
        val congViec = intent.getSerializableExtra("CONGVIEC_HIEN_TAI") as? CongViec
        congViec?.let {
            edtSuaTen.setText(it.tenCongViec)
            edtSuaMoTa.setText(it.moTa)
        }

        // Lưu và trả kết quả (Câu 3)
        btnLuu.setOnClickListener {
            congViec?.tenCongViec = edtSuaTen.text.toString().trim()
            congViec?.moTa = edtSuaMoTa.text.toString().trim()

            val intentKetQua = Intent()
            intentKetQua.putExtra("CONGVIEC_DA_SUA", congViec)
            setResult(RESULT_OK, intentKetQua)
            finish()
        }
    }
}