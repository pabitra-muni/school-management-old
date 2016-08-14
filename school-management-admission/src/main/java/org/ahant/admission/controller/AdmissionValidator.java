package org.ahant.admission.controller;

import com.google.common.base.Strings;
import org.ahant.admission.model.Admission;
import org.ahant.core.controller.DataValidator;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.Student;
import org.ahant.core.model.TaskData;

import static org.ahant.admission.constants.AdmissionConstants.NO_ADMISSION_DETAIL_ERROR_MSG;
import static org.ahant.core.util.CommonUtil.buildException;

/**
 * Created by ahant on 8/2/2016.
 */
public class AdmissionValidator implements DataValidator<Admission> {

    @Override
    public boolean validate(TaskData<Admission> taskData) {
        boolean returnValue = false;

        final Admission admission = taskData.getSource();
        if (admission != null) {
            try{

                checkStudentDetails(admission);
                returnValue = true;
            }catch (ApplicationException ex){
                taskData.setException(ex);
            }
        } else {
            taskData.setException(buildException(ApplicationException.class, NO_ADMISSION_DETAIL_ERROR_MSG));
        }
        return returnValue;
    }

    private void checkStudentDetails(final Admission admission) {
        Student student = admission.getStudent();
        if(Strings.isNullOrEmpty(student.getFullName())){
             throw buildException(ApplicationException.class, "fullName");
        }
        if(student.getBirthDate() == null){
            throw buildException(ApplicationException.class, "birthDate");
        }
        if(student.getGender() == null){
            throw buildException(ApplicationException.class, "gender");
        }
        if(student.getStandard() == null || student.getSection() == null){
            throw buildException(ApplicationException.class, "standard/ section");
        }
        if(student.getContactNumberList().isEmpty() || Strings.isNullOrEmpty(student.getContactNumberList().get(0))){
            throw buildException(ApplicationException.class, "contactNumber");
        }

    }
}
