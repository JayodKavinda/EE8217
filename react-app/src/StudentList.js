import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class StudentList extends Component {

    constructor(props) {
      super(props);
      this.state = {groups: [], isLoading: true};
      this.remove = this.remove.bind(this);
    }
  
    componentDidMount() {
      this.setState({isLoading: true});
  
      fetch('api/student')
        .then(response => response.json())
        .then(data => this.setState({groups: data, isLoading: false}));

     
    }
  
    async remove(id) {
      await fetch(`/api/student/${id}`, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      }).then(() => {
        let updatedGroups = [...this.state.groups].filter(i => i.id !== id);
        this.setState({groups: updatedGroups});
      });
    }
  
    render() {
      const {groups, isLoading} = this.state;
  
      if (isLoading) {
        return <p>Loading...</p>;
      }
  
      const groupList = groups.map(group => {
        
        return <tr key={group.id}>
            <td style={{whiteSpace: 'nowrap'}}>{group.id}</td>
          <td style={{whiteSpace: 'nowrap'}}>{group.firstName}</td>
          <td style={{whiteSpace: 'nowrap'}}>{group.lastName}</td>
          <td style={{whiteSpace: 'nowrap'}}>{group.faculty}</td>
          <td style={{whiteSpace: 'nowrap'}}>{group.gpa}</td>
          <td>
            <ButtonGroup>
              <Button size="sm" color="danger" onClick={() => this.remove(group.id)}>Delete</Button>
            </ButtonGroup>
          </td>
        </tr>
      });
  
      return (
        <div>
          <AppNavbar/>
          <Container fluid>
            <div className="float-right">
              <Button color="success" tag={Link} to="/new">Add New Student</Button>
            </div>
            <h3>Manage Students</h3>
            <Table className="mt-4">
              <thead>
              <tr>
                <th width="20%">Id</th>
                <th width="20%">First Name</th>
                <th>Last Name</th>
                <th>Faculty</th>
                <th>GPA</th>
                <th width="10%">Actions</th>
              </tr>
              </thead>
              <tbody>
              {groupList}
              </tbody>
            </Table>
          </Container>
        </div>
      );
    }
  }
  
  export default StudentList;
  