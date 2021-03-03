package com.example.doctorapp.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.doctorapp.R
import com.example.doctorapp.choose.chooselist.adapter.ChooseListAdapter
import com.example.doctorapp.choose.fragment.ChooseBookFragment
import com.example.doctorapp.choose.fragment.ChooseClassFragment
import com.example.doctorapp.choose.fragment.ChooseFaceFragment
import com.example.doctorapp.choose.fragment.ChooseVideoFragment
import com.example.doctorapp.choose.timer.bean.DownBean
import com.example.doctorapp.choose.timer.contract.DownContract
import com.example.doctorapp.choose.timer.presenter.DownPresenter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_blank.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class BlankFragment : Fragment(), DownContract.iDownView {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        initview(view)
        //准备资源
        initData()
        return view
    }

    private fun initview(view: View) {
        //找控件
        var keMu = view.findViewById<TextView>(R.id.kotlin_keMu)
        var kotlin_choose_doctor = view.findViewById<TextView>(R.id.kotlin_choose_doctor)
        var vap = view.findViewById<ViewPager>(R.id.kotlin_vap)
        var one = view.findViewById<TabLayout>(R.id.kotlin_table_one)

        var two = view.findViewById<TabLayout>(R.id.kotlin_table_two)

        val chooseClassFragment = ChooseClassFragment()
        val chooseVideoFragment = ChooseVideoFragment()
        val chooseBookFragment = ChooseBookFragment()
        val chooseFaceFragment = ChooseFaceFragment()
        val list = ArrayList<Fragment>()
        list.add(chooseClassFragment)
        list.add(chooseVideoFragment)
        list.add(chooseBookFragment)
        list.add(chooseFaceFragment)

        //适配器
        val chooseListAdapter = ChooseListAdapter(fragmentManager!!, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list)
        vap.setAdapter(chooseListAdapter)
        two.setupWithViewPager(vap)
        two.getTabAt(0)!!.setText("模拟试卷").setIcon(R.drawable.ic_all_ques)
        two.getTabAt(1)!!.setText("历年真题").setIcon(R.drawable.ic_chapter)
        two.getTabAt(2)!!.setText("VIP题库").setIcon(R.drawable.ic_vip_question)
        two.getTabAt(3)!!.setText("章节练习").setIcon(R.drawable.ic_simulation_test)
        //监听事件
        keMu.setOnClickListener {
            Toast.makeText(activity, "点击事件未做", Toast.LENGTH_SHORT).show()
        }

        //点击事件
        kotlin_choose_doctor.setOnClickListener {
            //popuWindown
            val inflate = LayoutInflater.from(activity).inflate(R.layout.choose_popu_item, null)

            //找控件
            val zhiye_doctor = inflate.findViewById<TextView>(R.id.zhiye_doctor)
            val zhiye_yaoshi = inflate.findViewById<TextView>(R.id.zhiye_yaoshi)
            val jiankang_doctor = inflate.findViewById<TextView>(R.id.jiankang_doctor)
            val zhicheng_doctor = inflate.findViewById<TextView>(R.id.zhicheng_doctor)
            val china_doctor = inflate.findViewById<TextView>(R.id.china_doctor)
            val xueli_tisheng = inflate.findViewById<TextView>(R.id.xueli_tisheng)
            val jineng_peixun = inflate.findViewById<TextView>(R.id.jineng_peixun)

            //弹窗
            val popupWindow = PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            popupWindow.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            popupWindow.isOutsideTouchable = true
            //位置
            //位置
            popupWindow.showAtLocation(kotlin_choose_doctor, Gravity.CENTER, 0, 0)
            //色差
            //色差
            val lp = activity!!.window.attributes
            lp.alpha = 0.3f
            activity!!.window.attributes = lp
            //空白位置关闭
            //空白位置关闭
            popupWindow.setOnDismissListener {
                val lp = activity!!.window.attributes
                lp.alpha = 1f
                activity!!.window.attributes = lp
                popupWindow.dismiss()
            }
            //医师监听
            zhiye_doctor.setOnClickListener {
                kotlin_choose_doctor.setText(zhiye_doctor.text.toString())
                popupWindow.dismiss()
            }

            //药师
            zhiye_yaoshi.setOnClickListener {
                kotlin_choose_doctor.setText(zhiye_yaoshi.text.toString())
                popupWindow.dismiss()
            }

            //健康管理师
            jiankang_doctor.setOnClickListener {
                kotlin_choose_doctor.setText(jiankang_doctor.text.toString())
                popupWindow.dismiss()
            }

            //职称药师
            zhicheng_doctor.setOnClickListener {
                kotlin_choose_doctor.setText(zhicheng_doctor.text.toString())
                popupWindow.dismiss()
            }

            //中医专长
            china_doctor.setOnClickListener {
                kotlin_choose_doctor.setText(china_doctor.text.toString())
                popupWindow.dismiss()
            }

            //学历提升
            xueli_tisheng.setOnClickListener {
                kotlin_choose_doctor.setText(xueli_tisheng.text.toString())
                popupWindow.dismiss()
            }

            //技能培训
            jineng_peixun.setOnClickListener {
                kotlin_choose_doctor.setText(jineng_peixun.text.toString())
                popupWindow.dismiss()
            }
        }
    }

    fun initData() {

        //倒计时
        val downPresenter = DownPresenter(this)
        downPresenter.getDown()
    }

    override fun onDownSuccess(downBean: DownBean) {
        // 规定日期的格式

        // 规定日期的格式
        val formater1 = SimpleDateFormat("yyyy-MM-dd")
        val date1 = downBean.data.endIncidentTime //获取结束时间

        val cal = Calendar.getInstance()
        /**
         * 获取现在的年月日
         */
        /**
         * 获取现在的年月日
         */
        val date2 = (cal[Calendar.YEAR].toString() + "-"
                + (cal[Calendar.MONTH] + 1) + "-"
                + cal[Calendar.DATE])
        // try里的日期是不能在下面直接用的，所以定义一个，当成功的情况传给day1
        // try里的日期是不能在下面直接用的，所以定义一个，当成功的情况传给day1
        var day1: Long = 0
        // 转化格式使用parse，但是需要try，catch一下
        // 转化格式使用parse，但是需要try，catch一下
        try {
            val d1 = formater1.parse(date1) // 转化第一个字符串为日期格式
            val d2 = formater1.parse(date2) // 转化第二个字符串为日期格式
            val days = (d1.time - d2.time) / 24 / 60 / 60 / 1000
            day1 = days
        } catch (e: ParseException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        kotlin_timer.setText("考试倒计时" + day1 + "天")
    }

    override fun onDownFail(error: String?) {
        //失败
        Log.e("TAG","失败"+error)
    }
}



