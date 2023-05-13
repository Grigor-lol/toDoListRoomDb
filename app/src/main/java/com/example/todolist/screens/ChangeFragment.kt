package com.example.todolist.screens

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todolist.MAIN
import com.example.todolist.POS
import com.example.todolist.R
import com.example.todolist.databinding.FragmentAddBinding
import com.example.todolist.databinding.FragmentChangeBinding
import com.example.todolist.model.TaskModel

class ChangeFragment : Fragment() {

    lateinit var binding: FragmentChangeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChangeBinding.inflate(layoutInflater, container, false)
        return binding.root
        return inflater.inflate(R.layout.fragment_change, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        var curElem = MAIN.curList[POS]
        binding.taskEditTextName.setText(curElem.textOfTask)
        var curText = binding.taskEditTextName.text.toString()
        binding.saveTaskButton.isEnabled = false
        binding.closeButton.setOnClickListener {
            MAIN.navController.navigate(R.id.action_changeFragment_to_mainFragment)
        }

        binding.deleteTaskButton.setOnClickListener {
            MAIN.taskDao.delete(curElem)
            MAIN.curList.removeAt(POS)
            MAIN.navController.navigate(R.id.action_changeFragment_to_mainFragment)
        }

        binding.taskEditTextName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (curText == binding.taskEditTextName.text.toString())
                    binding.saveTaskButton.isEnabled = false

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {

            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                binding.saveTaskButton.isEnabled = true

            }
        })

        binding.saveTaskButton.setOnClickListener {
            curElem.textOfTask =  binding.taskEditTextName.text.toString()
            MAIN.taskDao.updateTask(curElem)
            MAIN.navController.navigate(R.id.action_changeFragment_to_mainFragment)
        }
    }
}