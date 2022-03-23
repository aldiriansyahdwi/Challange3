package com.example.challange3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.navigation.fragment.findNavController
import com.example.challange3.databinding.FragmentThirdBinding
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aName = ThirdFragmentArgs.fromBundle(arguments as Bundle).name
        binding.tvName.visibility = View.VISIBLE
        binding.tvName.text = "Hello, $aName!"
        binding.tvDesc.visibility = View.GONE
        binding.tvPrice.visibility = View.GONE


        val objectSalmon = ThirdFragmentArgs.fromBundle(arguments as Bundle).dataSalmon

        if (objectSalmon != null) {
            val salmonLength = objectSalmon.length
            val salmonWeight = objectSalmon.weight
            val salmonQuality = objectSalmon.quality
            val salmonType: Double = when (objectSalmon.type){
                true -> 1.0
                else -> 0.6
            }
            val salmonTypeText = when (objectSalmon.type){
                true -> "Wild"
                else -> "Cattle"
            }

            val salmonPrice = (salmonLength?.times(4000)?.times(salmonWeight?.div(3)!!)
                ?.times(0.5+salmonQuality!!)?.times(salmonType))

//            binding.tvName.visibility = View.GONE
            binding.tvDesc.visibility = View.VISIBLE
            binding.tvDesc.text = "Your Salmon that is $salmonLength cm long and weighs $salmonWeight Kg from $salmonTypeText is: "
            binding.tvPrice.visibility = View.VISIBLE
            binding.tvPrice.text = "Rp ${salmonPrice?.format(2)}"
            binding.btnGotoFourth.visibility = View.GONE
        }
        binding.btnGotoFourth.setOnClickListener {
            val actionToFourthFragment = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(aName)
            findNavController().navigate(actionToFourthFragment)
        }
    }

    private fun Double.format(digits:Int) = String.format("%#,.${digits}f", this)

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}