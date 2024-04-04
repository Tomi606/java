import './App.css';
import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate, Navigate} from 'react-router-dom'

function App() {

  let [list, setList] = useState([]);

  function add(movie){
    setList([...list, movie]);
  }
  function remove(id){
    let tmpList = list.filter(item=>item.id != id);
    setList(tmpList);
  }
  return (
    <BrowserRouter>
      <Nav/>
      <Routes>
        <Route path="/" exact element={<List list={list} add={add} remove={remove}/>} />
        <Route path="/add" element={<Add/>} />
      </Routes>
    </BrowserRouter>
  );
}
function Nav(){
  return (
    <ul className="menu-list">
      <li><Link to="/">List</Link></li>
      <li><Link to="/add">Add New Movie</Link></li>
    </ul>
  );
}
function List({list, add, remove}){

  const location = useLocation();
  let movie = location.state;
  if(movie != null){
    add(movie);
    location.state = null;
  }
  return (
    <div className='container'>
      <h1 className='title'>Movies</h1>
      <table className='table'>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Realease Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {
            list.map((item)=>{
              return (
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td>{item.title}</td>
                  <td>{item.genre}</td>
                  <td>{item.release_date}</td>
                  <td><button onClick={()=>remove(item.id)}>Delete</button></td>
                </tr>
              )
            })
          }
          
        </tbody>
      </table>
    </div>
  );
}
function Add(){
  let [id, setid] = useState(0);
  let [genre, setGenre] = useState("");
  let [title, setTitle] = useState("");
  let [release_date, setRelease_date] = useState("");

  const idChange = (e) => setid(e.target.value);
  const genreChange = (e) => setGenre(e.target.value);
  const titleChange = (e) => setTitle(e.target.value);
  const release_dateChange = (e) => setRelease_date(e.target.value);

  const navigate = useNavigate();

  function addMovie(){
    navigate("/",{
      state : {
        title,
        release_date,
        genre,
        id
      }
    })
  }
  
  return (
    <div className='container'>
      <div>
        <h1 className='title'>Creat Movie</h1>
        <div>
          <input type="id" onChange={idChange} placeholder='Input movie id'/>
        </div>
        <div>
          <input type="text" onChange={titleChange} placeholder='Input movie title'/>
        </div>
        <div>
          <input type="text" onChange={genreChange} placeholder='Input movie genre'/>
        </div>
        <div>
          <label>출시일 : </label>
          <input type="date" onChange={release_dateChange}/>
        </div>
        <button onClick={addMovie}>Add Movie</button>
      </div>
    </div>
  )
}
export default App;