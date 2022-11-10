package com.example.mangaapp

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class TrangChu : AppCompatActivity() {

    lateinit var customAdapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trang_chu)

        Toast.makeText(this, "Đăng nhập thành công",Toast.LENGTH_LONG).show()

        var list = mutableListOf<OutData>()

        list.add(OutData(R.drawable.chuyensinhthanhtieusu, "CHUYỂN SINH THÀNH TIÊU SƯ", "Truyện tranh Chuyển Sinh Thành Tiêu Sư được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Chuyển Sinh Thành Tiêu Sư."))
        list.add(OutData(R.drawable.kyuuchan, "NHÀ HÀNG THỢ SĂN QUÁI VẬT","Truyện tranh Nhà Hàng Thợ Săn Quái Vật được cập nhật nhanh và đầy đủ nhất tại NetTruyen. Bạn đọc đừng quên để lại bình luận và chia sẻ, ủng hộ NetTruyen ra các chương mới nhất của truyện Nhà Hàng Thợ Săn Quái Vật."))
        list.add(OutData(R.drawable.hoiphapsu,"HỘI PHÁP SƯ VÀ THÁNH THẠCH RAVE","Sẽ là một câu chuyện kết hợp thế giới ma thuật của Fairy Tail và Thánh Thạch Rave"))

        customAdapter = CustomAdapter(this, list)
        var lvManga = findViewById<ListView>(R.id.lvManga)
        lvManga.adapter = customAdapter
    }

}