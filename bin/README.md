   # Dog Grooming App TODO

## Now
- [X] Shift entity (groomer, day, start time, end time), seeded for Kristina
  - [X] Decide the shape first: one row per working day, or seven fields on Groomer
  - [X] Determine how lunch localTime will work with timeStart and endTime
   -- Determined that we need two entities, WeeklyAvailability, and DailyShiftLog. WeeklyAvailability (WA) will be used as a recurring default for the groomer. DailyShiftLog (DL) will be used to log actual times the employee clocks in and out for their shift and lunch. WA has variables called defaultLunchStart and lunchDurationMinutes, which DL uses as the baseline to check that the employee's actual shift and lunch times stay in compliance.
 - [ ] Create a mock employee with WeeklyAvailability (WA) set up, then try to create an appointment which follows mock rules. Mock rules are such, can only book appointments after shift has started, cannot book appointment during lunch, cannot book appointment after shift has ended.


## Next
- [ ] Create a valid appointment entity with working scheduling from Employee relationship with Shift Entity
