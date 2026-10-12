package com.ute.vdthigk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvThongTinCongViec: TextView
    private var congViecHienTai: CongViec? = null

    // Đăng ký Activity Result API (Câu 3)
    private val launcherChinhSua = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val congViecDaSua = data?.getSerializableExtra("CONGVIEC_DA_SUA") as? CongViec
            if (congViecDaSua != null) {
                congViecHienTai = congViecDaSua
                hienThiThongTin()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvThongTinCongViec = findViewById(R.id.tvThongTinCongViec)
        val btnChinhSua = findViewById<Button>(R.id.btnChinhSua)
        val btnHoanThanh = findViewById<Button>(R.id.btnHoanThanh)

        // Nhận dữ liệu từ MainActivity (Câu 2 & 4)
        congViecHienTai = intent.getSerializableExtra("DULIEU_CONGVIEC") as? CongViec
        hienThiThongTin()

        // Nút Chỉnh sửa (Câu 3)
        btnChinhSua.setOnClickListener {
            val intentSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentSua.putExtra("CONGVIEC_HIEN_TAI", congViecHienTai)
            launcherChinhSua.launch(intentSua)
        }

        // Nút Đánh dấu hoàn thành (Câu 5)
        btnHoanThanh.setOnClickListener {
            congViecHienTai?.trangThai = "Đã hoàn thành"
            hienThiThongTin()
        }
    }

    private fun hienThiThongTin() {
        congViecHienTai?.let {
            tvThongTinCongViec.text = it.thongTinCongViec()
        }
    }
}