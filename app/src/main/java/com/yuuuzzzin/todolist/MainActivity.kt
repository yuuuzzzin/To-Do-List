package com.yuuuzzzin.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuuuzzzin.todolist.database.Todo
import com.yuuuzzzin.todolist.database.TodoViewModel
import com.yuuuzzzin.todolist.database.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var todayAdapter : TodoAdapter
    lateinit var viewModel : TodoViewModel
    lateinit var todoList: MutableLiveData<MutableList<Todo>>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, ViewModelProviderFactory(this.application))
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