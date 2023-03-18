package BTVN_Day01.jobpost.service;

import BTVN_Day01.jobpost.model.Job;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService {
    private List<Job> jobList = new ArrayList<>();

    public JobService() {
        jobList.add(new Job("job01", "Front-end Developer", "Hanoi", 1000, 1500));
        jobList.add(new Job("job02", "PHP Developer", "Hanoi", 1500, 2500));
        jobList.add(new Job("job03", "Senior Java Developer", "Ho Chi Minh", 2000, 4000));
        jobList.add(new Job("job04", "iOS Developer", "Singapore", 2500, 3000));
        jobList.add(new Job("job05", "Database Administrator", "Ho Chi Minh", 1500, 2000));
    }

    public Job getRandomJob() {
        Random rd = new Random();
        int index = rd.nextInt(jobList.size()-1);
        return jobList.get(index);
    }

    public List<Job> sortJobsByMaxSalary(String sortOder) {
        if (sortOder.equalsIgnoreCase("desc")) {
            Collections.sort(jobList, new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return (o2.getMaxSalary() > o1.getMaxSalary()) ? 1 : -1;
                }
            });
            return jobList;
        } else if (sortOder.equalsIgnoreCase("asc")) {
            Collections.sort(jobList, new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return (o1.getMaxSalary() > o2.getMaxSalary()) ? 1 : -1;
                }
            });
            return jobList;
        }
        return null;
    }
}