Installation instructions and description of the tasks.

------------------------------------------------------------------------
1. Prerequisites.
------------------------------------------------------------------------

Below the prerequisites for the installation.
- Eclipse installed.
To know how to prepare the environment, please see the video tutorial (Section 2, Topic 1).

------------------------------------------------------------------------
2. Preparing the MyFirstSwingApp project.
------------------------------------------------------------------------

To import the MyFirstSwingApp project, please the tasks described below:
- Open Eclipse -> File -> Import.
- General -> Existing projects into workspace -> Next.
- Complete the 'Select archive file' with the MyFirstSwingApp.zip file -> Finish.

The project supposes to be stored in the '/home/pentaho/workspace' folder.
If this is not the case, please execute the two different tasks described below.

The first task is to update the 'my first localized report.prpt' report stored in the resources folder.
Open the report directly with the Pentaho Report Designer and update the data source connection to SampleData that should refers to the correct path (now is '/home/pentaho/workspace/MyFirstSwingApp/...').

The second task is to update the 'reportPath' variable in the MyFirstSwingApp class.

------------------------------------------------------------------------
3. Tasks and instructions.
------------------------------------------------------------------------

Select MyFirstSwingApp class from Eclipse and run the application using the green button with the white arrow in the Run menu (or press Ctrl + F11).
Pressing the unique button in the new window with the 'Press me!' label, you will see the report with a localized title.
