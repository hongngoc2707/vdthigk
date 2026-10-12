package com.ute.vdthigk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var tvThongTinSinhVien: TextView
    private lateinit var edtTenCongViec: EditText
    private lateinit var edtMoTaCongViec: EditText
    private lateinit var btnTaoCongViec: Button
    private lateinit var btnXemDanhSach: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTaCongViec = findViewById(R.id.edtMoTaCongViec)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)
        btnTaoCongViec.setOnClickListener {
            val ten = edtTenCongViec.text.toString().trim()
            val moTa = edtMoTaCongViec.text.toString().trim()

            // Câu 5: Kiểm tra rỗng
            if (ten.isEmpty()) {
                Toast.makeText(this, "Tên công việc không được để trống!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Câu 2 & 4: Dùng Intent truyền Object
            val congViecMoi = CongViec(ten, moTa)
            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("DULIEU_CONGVIEC", congViecMoi)
            startActivity(intent)
        }
    }
}