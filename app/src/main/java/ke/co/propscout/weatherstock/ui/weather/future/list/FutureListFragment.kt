package ke.co.propscout.weatherstock.ui.weather.future.list

import ke.co.propscout.weatherstock.R
import ke.co.propscout.weatherstock.databinding.FutureListFragmentBinding
import ke.co.propscout.weatherstock.ui.BaseFragment

class FutureListFragment : BaseFragment<FutureListFragmentBinding, FutureListViewModel>() {
    override fun getViewModel() = FutureListViewModel::class.java
    override fun getFragmentLayout() = R.layout.future_list_fragment
}