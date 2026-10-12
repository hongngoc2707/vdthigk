package com.ute.vdthigk

import java.io.Serializable

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: String = "Chưa hoàn thành"
) : Serializable {

    fun thongTinCongViec(): String {
        return "Tên công việc: $tenCongViec\nMô tả: $moTa\nTrạng thái: $trangThai"
    }
}