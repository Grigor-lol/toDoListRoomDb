package com.example.todolist.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todolist.Main
import com.example.todolist.R
import com.example.todolist.databinding.FragmentAddBinding
import com.example.todolist.model.TaskModel

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.closeButton.setOnClickListener {
            Main.navController.navigate(R.id.action_addFragment_to_mainFragment)
        }

        binding.addTaskButton.setOnClickListener {
            if (binding.taskEditText.text.toString() != "") {
                val newTask = TaskModel(binding.taskEditText.text.toString(), 0)
                Main.addTask(newTask)
                Main.navController.navigate(R.id.action_addFragment_to_mainFragment)
            }
        }
    }
}