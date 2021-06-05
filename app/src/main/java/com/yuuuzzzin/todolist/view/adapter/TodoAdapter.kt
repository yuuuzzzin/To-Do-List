package com.yuuuzzzin.todolist.view.adapter

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.yuuuzzzin.todolist.view.EditActivity
import com.yuuuzzzin.todolist.R
import com.yuuuzzzin.todolist.model.Todo
import com.yuuuzzzin.todolist.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.item_todolist.view.*

class TodoAdapter(val context: Context,
                  var itemList: MutableList<Todo>,
                  val viewModel: TodoViewModel,
                  val setList: () -> Unit
                  //,val goToEditListener : (Todo, Int) -> Unit
) : RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_todolist,parent,false)

        return MyViewHolder(view)
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val todoTitle = itemView.todo_title
        val todoEdit = itemView.todo_edit
        val todoDelete = itemView.todo_delete
        val todoIsCompleted: CheckBox = itemView.todo_completed
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todo = itemList[position]

        holder.todoTitle.text = todo.text

        holder.todoIsCompleted.isChecked = todo.isCompleted

        if (todo.isCompleted) {
            holder.todoTitle.
            apply {
                setTextColor(Color.GRAY)
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
        } else {
            holder.todoTitle.apply {
                setTextColor(Color.BLACK)
                paintFlags = 0
            }
        }

        holder.todoIsCompleted.apply {
            setOnClickListener {
                todo.isCompleted = this.isChecked
                viewModel.update(todo)
                setList()
            }
        }

//        holder.todoEdit.setOnClickListener {
//            goToEditListener(todo, position)
//        }

        holder.todoDelete.setOnClickListener {
            val alertDialog = AlertDialog.Builder(context)
                .setMessage("할 일을 삭제하시겠습니까?")
                .setPositiveButton("삭제") {str, dialogInterface ->
                    val todo = itemList[position]
                    viewModel.delete(todo)
                    setList()
                }
                .setNegativeButton("취소",null)
            alertDialog.show()
        }

        holder.todoEdit.setOnClickListener {
            val intent = Intent(holder.itemView?.context, EditActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("todo", todo)
            intent.putExtra("data", bundle)
            intent.putExtra("position", position)
            startActivityForResult(holder.itemView.context as Activity, intent, 101, null)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}