Installation instructions and description of the tasks.

------------------------------------------------------------------------
1. Prerequisites.
------------------------------------------------------------------------

Below the prerequisites for the installation.
- Eclipse installed.
- Tomcat installed as server in Eclipse.
To know how to prepare the environment, please see the video tutorial (Section 2, Topic 1).

------------------------------------------------------------------------
2. Preparing the MyFirstWebApp project.
------------------------------------------------------------------------

To import the MyFirstWebApp project, please the tasks described below:
- Open Eclipse -> File -> Import.
- General -> Existing projects into workspace -> Next.
- Complete the 'Select archive file' with the MyFirstWebApp.zip file -> Finish.

The project supposes to be stored in the '/home/pentaho/workspace' folder.
If this is not the case, please execute the two different tasks described below.

The first task is to update the 'my first report with parameter.prpt' report stored in the resources folder.
Open the report directly with the Pentaho Report Designer and update the data source connection to SampleData that should refers to the correct path (now is '/home/pentaho/workspace/MyFirstWebApp/...').

The second task is to update the 'reportPath' variable in the MyFirstWebApp class.

------------------------------------------------------------------------
3. Deploy the MyFirstWebApp project.
------------------------------------------------------------------------

To deploy MyFirstWebApp project simply drag it from the left panel in Eclipse and drop it to the Servers panel directly in Tomcat.
Please, start the Tomcat server using the green button with the white arrow in the Servers panel.

------------------------------------------------------------------------
4. Tasks and instructions.
------------------------------------------------------------------------

Open the browser accessing to 'http://localhost:8080/MyFirstWebApp'.
Clicking to the unique link (directly in the 'here' word) you will access to the report in pdf format.
