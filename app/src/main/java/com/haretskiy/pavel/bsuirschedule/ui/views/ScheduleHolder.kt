package com.haretskiy.pavel.bsuirschedule.ui.views

import android.support.v7.widget.RecyclerView
import android.view.View
import com.haretskiy.pavel.bsuirschedule.EMPTY_STRING
import com.haretskiy.pavel.bsuirschedule.models.ScheduleUnit
import com.haretskiy.pavel.bsuirschedule.toPrettyFormat
import kotlinx.android.synthetic.main.item_schedule.view.*

class ScheduleHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bindHolder(scheduleUnit: ScheduleUnit) {

        fillAuditory(scheduleUnit)
        fillEmployee(scheduleUnit)
        fillLessonTime(scheduleUnit)
        fillLessonType(scheduleUnit)
        fillNote(scheduleUnit)
        fillSubGroup(scheduleUnit)
        fillSubject(scheduleUnit)
        fillWeekNumber(scheduleUnit)
    }


    private fun fillSubject(scheduleUnit: ScheduleUnit) {
        view.subject.text = scheduleUnit.subject
    }

    private fun fillNote(scheduleUnit: ScheduleUnit) {
        if (scheduleUnit.note.isNotEmpty()) {
            view.note.text = scheduleUnit.note
            view.note.visibility = View.VISIBLE
        } else {
            view.note.visibility = View.GONE
        }
    }

    private fun fillWeekNumber(scheduleUnit: ScheduleUnit) {
        if (scheduleUnit.weekNumber.isNotEmpty()) {
            view.week_number.text = scheduleUnit.weekNumber.toString()
        }
    }

    private fun fillSubGroup(scheduleUnit: ScheduleUnit) {
        if (!scheduleUnit.numSubgroup.equals(0)) {
            view.subgroup.text = scheduleUnit.numSubgroup.toString()
        }
    }

    private fun fillLessonType(scheduleUnit: ScheduleUnit) {
        view.type_lesson.text = scheduleUnit.lessonType
    }

    private fun fillLessonTime(scheduleUnit: ScheduleUnit) {
        val lessonTime = "${scheduleUnit.startLessonTime} - ${scheduleUnit.endLessonTime}"
        view.lesson_time.text = lessonTime
    }

    private fun fillEmployee(scheduleUnit: ScheduleUnit) {
        var empStr = EMPTY_STRING
        if (scheduleUnit.employee.size > 1) {
            for (emp in scheduleUnit.employee) {
                val employee = "${emp.toPrettyFormat()}\n"
                empStr += employee
            }
            view.employee.visibility = View.VISIBLE
        } else if (scheduleUnit.employee.size == 1) {
            view.employee.visibility = View.VISIBLE
            empStr = scheduleUnit.employee[0].toPrettyFormat()
        } else {
            view.employee.visibility = View.GONE
        }
        view.employee.text = empStr
    }

    private fun fillAuditory(scheduleUnit: ScheduleUnit) {
        var audStr = EMPTY_STRING
        for (aud in scheduleUnit.auditory) {
            val auditory = "$aud, "
            audStr += auditory
        }
        if (audStr.length > 2) {
            audStr.subSequence(0, audStr.length - 2)
            view.auditory.text = audStr
        }
    }

}