package com.example.currencyconverterapp.ui.ratesListFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverterapp.R
import com.example.currencyconverterapp.databinding.FragmentRatesListBinding
import com.example.currencyconverterapp.ui.adapter.RatesAdapter
import com.example.currencyconverterapp.ui.adapter.RatesCallBack
import com.example.currencyconverterapp.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RatesListFragment : Fragment(R.layout.fragment_rates_list), RatesCallBack {

    private lateinit var binding: FragmentRatesListBinding
    private val viewmodel by activityViewModels<MainViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRatesListBinding.bind(view)

        binding.apply {
            list.layoutManager = LinearLayoutManager(context)
            list.addItemDecoration(
                DividerItemDecoration(
                    list.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            viewmodel.repositoriesLiveData.observe(viewLifecycleOwner, Observer {
                val currency = mutableListOf<String>()
                val rates = mutableListOf<Double>()
                it.rates.entries.forEach { map ->
                    currency.add(map.key)
                    rates.add(map.value)
                }
                val ratesAdapter = RatesAdapter(currency, rates, this@RatesListFragment)
                list.adapter = ratesAdapter
            })
        }
    }

    override fun onClick(currencyName: String, rateValue: Double) {
        val bundle = Bundle()
        bundle.putString("currency", currencyName)
        bundle.putDouble("rate", rateValue)
        Navigation.findNavController(binding.root).navigate(R.id.action_ratesListFragment_to_convertFragment, bundle)
    }
}