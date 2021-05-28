package com.example.currencyconverterapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blongho.country_data.World
import com.example.currencyconverterapp.databinding.ItemListBinding
import com.mynameismidori.currencypicker.CurrencyPicker
import com.mynameismidori.currencypicker.ExtendedCurrency
import java.util.*

class RatesAdapter(
    private val currencies: MutableList<String>,
    private val rates: MutableList<Double>,
    private val callBack: RatesCallBack
) : RecyclerView.Adapter<RatesAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun getItemCount() = currencies.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val currentCurrency = currencies[position]
        val currentRate = rates[position]
        holder.bind(currentCurrency, currentRate)
    }

    inner class VH(private var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(currencyName: String, rateValue: Double) {
            binding.apply {
                currency = currencyName
                rates = rateValue
                callback = callBack
                if (ExtendedCurrency.getCurrencyByISO(currencyName) != null)
                logo.setImageResource(ExtendedCurrency.getCurrencyByISO(currencyName).flag)
            }
        }
    }
}