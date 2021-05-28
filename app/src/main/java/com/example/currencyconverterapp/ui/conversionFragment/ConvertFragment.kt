package com.example.currencyconverterapp.ui.conversionFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.currencyconverterapp.R
import com.example.currencyconverterapp.databinding.FragmentConvertBinding
import com.example.currencyconverterapp.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConvertFragment : Fragment(R.layout.fragment_convert) {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: FragmentConvertBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConvertBinding.bind(view)
        val currencyName = requireArguments().getString("currency")!!
        val rateValue = requireArguments().getDouble("rate")
        binding.apply {
            currency = currencyName
            rates = rateValue
            viewmodel = viewModel

            viewModel.getUserInput.observe(viewLifecycleOwner, Observer {
                if (!it.isNullOrEmpty())
                    resultRate.text = String.format("%.2f", it.toDoubleOrNull()?.times(rateValue))
            })
        }
    }
}