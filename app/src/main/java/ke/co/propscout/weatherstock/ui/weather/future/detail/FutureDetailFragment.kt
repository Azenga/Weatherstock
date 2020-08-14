package ke.co.propscout.weatherstock.ui.weather.future.detail

import ke.co.propscout.weatherstock.R
import ke.co.propscout.weatherstock.databinding.FutureDetailFragmentBinding
import ke.co.propscout.weatherstock.ui.BaseFragment

class FutureDetailFragment : BaseFragment<FutureDetailFragmentBinding, FutureDetailViewModel>() {
    override fun getViewModel() = FutureDetailViewModel::class.java
    override fun getFragmentLayout() = R.layout.future_detail_fragment

}