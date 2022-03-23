package com.example.challange3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isNotEmpty
import androidx.navigation.fragment.findNavController
import com.example.challange3.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    companion object{
        val OBJECT_SALMON = "OBJECT_SALMON"
    }

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGotoThird.setOnClickListener {
            if(binding.etLength.text.isNullOrEmpty() || binding.etWeight.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Length and Weight cannot empty", Toast.LENGTH_SHORT).show()
            }
            else if (!binding.rbWild.isChecked && !binding.rbCattle.isChecked) {
                Toast.makeText(requireContext(), "Select salmon type", Toast.LENGTH_SHORT).show()
            }
            else {
                val aSalmon = Salmon(binding.etLength.text.toString().toDouble(), binding.etWeight.text.toString().toDouble(), checkBoxQualityClicked(), radioButtonTypeClicked())

                val actionBackToThirdFragment = FourthFragmentDirections.actionFourthFragmentToThirdFragment(aSalmon)
                    findNavController().navigate(actionBackToThirdFragment)
            }
        }
    }

    private fun radioButtonTypeClicked(): Boolean{
        return when{
            binding.rbWild.isChecked -> true
            else -> false
        }
    }

    private fun checkBoxQualityClicked(): Double{
        var n = 0.0
        if (binding.cbSmell.isChecked){
            n += 0.1
        }
        if (binding.cbEyes.isChecked){
            n += 0.1
        }
        if (binding.cbChewy.isChecked){
            n += 0.1
        }
        if (!binding.cbSoft.isChecked){
            n += 0.1
        }
        if (!binding.cbMucus.isChecked){
            n += 0.1
        }
        return n
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}