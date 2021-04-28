package com.yuuuzzzin.todolist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yuuuzzzin.todolist.database.Todo
import com.yuuuzzzin.todolist.database.TodoViewModel
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    lateinit var todo: Todo
    lateinit var bundle : Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        bundle = intent.getBundleExtra("data")!!

        bundle?.apply {
            todo = getSerializable("todo") as Todo
            tv_edit_todo.setText(todo.text)

            bt_edit_cancel.setOnClickListener(editBtListener)
            bt_edit_save.setOnClickListener(editBtListener)
        }
    }

    val editBtListener = View.OnClickListener { view->

        when (view) {
            bt_edit_save -> {
                todo.text = tv_edit_todo.text.toString()

                bundle.putSerializable("todo",todo)
                intent.putExtra("data",bundle)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }

            bt_edit_cancel -> {
                setResult(Activity.RESULT_CANCELED, intent)
                finish()
            }
        }
    }

}