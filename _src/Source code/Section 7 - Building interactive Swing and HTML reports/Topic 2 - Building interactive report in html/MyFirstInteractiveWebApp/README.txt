Installation instructions and description of the tasks.

------------------------------------------------------------------------
1. Prerequisites.
------------------------------------------------------------------------

Below the prerequisites for the installation.
- Eclipse installed.
- Tomcat installed as server in Eclipse.
To know how to prepare the environment, please see the video tutorial (Section 2, Topic 1).

------------------------------------------------------------------------
2. Preparing the MyFirstInteractiveWebApp project.
------------------------------------------------------------------------

To import the MyFirstInteractiveWebApp project, please the tasks described below:
- Open Eclipse -> File -> Import.
- General -> Existing projects into workspace -> Next.
- Complete the 'Select archive file' with the MyFirstInteractiveWebApp.zip file -> Finish.

The project supposes to be stored in the '/home/pentaho/workspace' folder.
If this is not the case, please execute the two different tasks described below.

The first task is to update the 'my first interactive report.prpt' report and 'subreport.prpt' report stored in the resources folder.
Open the report directly with the Pentaho Report Designer and update the data source connection to SampleData that should refers to the correct path (now is '/home/pentaho/workspace/MyFirstInteractiveWebApp/...').

The second task is to update the 'reportPath' variable in the MyFirstInteractiveWebApp and MySubReport classes.

------------------------------------------------------------------------
3. Deploy the MyFirstInteractiveWebApp project.
------------------------------------------------------------------------

To deploy MyFirstInteractiveWebApp project simply drag it from the left panel in Eclipse and drop it to the Servers panel directly in Tomcat.
Please, start the Tomcat server using the green button with the white arrow in the Servers panel.

------------------------------------------------------------------------
4. Tasks and instructions.
------------------------------------------------------------------------

Open the browser accessing to 'http://localhost:8080/MyFirstInteractiveWebApp'.
Clicking to the unique link (directly in the 'here' word) you will access to the report in pdf format.
Press the 'Change title' button to modify the report's title.
Press the 'Stock' quantities to see a child window showing the specific price for each product line.
Click on the 'Product line' description to access to the sub-report showing the details.

