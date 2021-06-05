package com.yuuuzzzin.todolist.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuuuzzzin.todolist.R
import com.yuuuzzzin.todolist.view.adapter.TodoAdapter
import com.yuuuzzzin.todolist.model.Todo
import com.yuuuzzzin.todolist.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var todayAdapter : TodoAdapter
    lateinit var viewModel : TodoViewModel
    lateinit var todoList: MutableLiveData<MutableList<Todo>>

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 액티비티에 연결된 뷰 모델 객체를 참조
        viewModel = ViewModelProvider(this)
            .get(TodoViewModel::class.java)

        //recycler view에 보여질 아이템 Room에서 받아오기
        todoList = viewModel.mutableLiveData
        todoList.observe(this, Observer {
            todayAdapter.itemList = it
            todayAdapter.notifyDataSetChanged()
        })

        todayAdapter = TodoAdapter(this, mutableListOf<Todo>(), viewModel, ::setList)

        //recycler view에 adapter와 layout manager 넣기
        today_list.adapter = todayAdapter
        today_list.layoutManager = LinearLayoutManager(this)


        todo_add.setOnClickListener {
            if (todo_input.text.toString() != "") {
                val todo = Todo(todo_input.text.toString())
                viewModel.insert(todo)
                setList()
                todo_input.setText("")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)

        val actionView = layoutInflater.inflate(R.layout.custom_toolbar, null)
        supportActionBar?.customView = actionView

        val searchView = actionView.findViewById<SearchView>(R.id.button_search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //검색어 입력버튼을 누른 후 내용이 있다면
                if (query != "" && query != null) {
                    //검색어를 통해 TodoList를 얻어옴.
                    todoList.value = viewModel.Search(query)
                } else {
                    setList()
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        //검색 닫기를 누른 후 기본 TodoList로 복귀
        searchView.setOnCloseListener {
            setList()
            false
        }

        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {

            val bundle = data?.getBundleExtra("data")
            val todo = bundle?.getSerializable("todo") as Todo
            viewModel.update(todo)
            setList()
        }
    }

    fun setList() {
        todoList.value = viewModel.getAll()
    }
}