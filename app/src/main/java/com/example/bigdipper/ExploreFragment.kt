package com.example.bigdipper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODOLIST: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreFragment : Fragment() {
    // TODOLIST: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var adapter: BookClubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_explore, container, false)
        val bookClubList = view.findViewById<RecyclerView>(R.id.bookClubList)
        bookClubList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter =  BookClubAdapter(dummyGenerator())
        adapter.itemClickListener = object:BookClubAdapter.onItemClickListener{
            override fun onItemClick(data: BookClubData, position: Int) {
                Toast.makeText(context, data.clubName, Toast.LENGTH_SHORT).show()
            }
        }
        bookClubList.adapter = adapter
        return view
    }


    // 더미 데이터 생성 함수
    private fun dummyGenerator(): ArrayList<BookClubData>{
        var dummy = ArrayList<BookClubData>();
        var item1 = BookClubData("imgstr", "북클럽 리더 1", "마케팅 북클럽" ,
            arrayListOf<String>("기획/마케팅", "경영"), "마케팅을 공부하는 북클럽입니다. 관심 있는 분 많이 오세요.", "10")
        var item2 = BookClubData("imgstr", "북클럽 리더 2", "창업/컴퓨터 북클럽" ,
            arrayListOf<String>("IT/컴퓨터", "경영"), "창업/컴퓨터를 공부하는 북클럽입니다. 관심 있는 분 많이 오세요.", "7")
        var item3 = BookClubData("imgstr", "북클럽 리더 3", "자기계발 북클럽" ,
            arrayListOf<String>("자기 계발/취미"), "자기계발 책 읽으면서 꾸준히 할 사람들이 모인 모임입니다. 많이 오세요.", "3")
        var item4 = BookClubData("imgstr", "북클럽 리더 4", "소설 북클럽" ,
            arrayListOf<String>("소설"), "소설 위주로 읽는 북클럽입니다 관심 있는 분 많이 오세요.", "5")
        var item5 = BookClubData("imgstr", "북클럽 리더 5", "철학 북클럽" ,
            arrayListOf<String>("고전 문학", "인문"), "철학 관련된 책을 읽으며 사색하는 북클럽입니다. 관심 있는 분 많이 오세요.", "12")
        dummy.add(item1)
        dummy.add(item2)
        dummy.add(item3)
        dummy.add(item4)
        dummy.add(item5)

        return dummy
    }
}